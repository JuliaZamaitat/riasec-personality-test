import Link from 'next/link';
import { useRouter } from 'next/navigation';
import { useState, useEffect } from 'react';

export default function Test(props: ITestProps) {
  const { test } = props;
  const [bgColor, setBgColor] = useState('');
  const router = useRouter();

  useEffect(() => {
    const hue = Math.floor(Math.random() * 360); // Random hue
    const saturation = Math.floor(Math.random() * 51) + 50; // 50-100% saturation
    const lightness = Math.floor(Math.random() * 26) + 70; // 70-95% lightness
    const randomColor = `hsl(${hue}, ${saturation}%, ${lightness}%)`;
    setBgColor(randomColor);
  }, []);

  const handleClick = (e: any) => {
    e.preventDefault();
    const value = localStorage.getItem('email') || '';
    console.log('value ' + value);
    if (value !== '') {
      router.push(`/tests/${test.id}/quiz`);
    } else router.push(`/tests/${test.id}`);
  };

  return (
    <>
      <Link
        href={`/tests/${test.id}`}
        className="flex flex-row m-5"
        onClick={handleClick}
      >
        <div
          className={`box w-48 rounded-l-lg flex-shrink-0 drop-shadow-md`}
          style={{ backgroundColor: bgColor }}
        ></div>
        <div className="">
          <div className="flex flex-col bg-neutral-100 hover:bg-white border-t border-r border-b border-gray-200 rounded-r-lg shadow md:max-w-xl p-4">
            <h2 className="mb-2 text-2xl font-bold tracking-tight text-[#ce43a7]">
              {test.title}
            </h2>
            <p className="mb-3 font-normal text-[#666666]">
              {test.description}
            </p>
            <p className="mb-3 font-normal text-[#666666]">
              Version: {test.version}
            </p>
          </div>
        </div>
      </Link>
    </>
  );
}
