import { useEffect, useState } from 'react';
import { getResult } from '../app/util/result';
import Link from 'next/link';

export default function Result({
  answers,
  testId,
}: {
  answers: any;
  testId: number;
}) {
  const [data, setData] = useState<null | IData>(null);
  const [isLoading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);
    getResult(testId, answers).then((data: IData) => {
      setData(data);
      setLoading(false);
    });
  }, []);

  if (isLoading) {
    return (
      <div className="flex justify-center items-center h-screen">
        <div className="max-w-2xl mx-auto">
          <button type="button" disabled>
            <div className="flex items-center">
              <svg className="animate-spin h-5 w-5 mr-3" viewBox="0 0 24 24">
                <circle
                  className="opacity-25"
                  cx="12"
                  cy="12"
                  r="10"
                  stroke="white"
                  strokeWidth="4"
                ></circle>
                <path
                  className="opacity-75"
                  fill="white"
                  d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"
                ></path>
              </svg>
              <span className="text-white text-2xl">Loading results...</span>
            </div>
          </button>
        </div>
      </div>
    );
  }

  if (!data) return <p>Error fetching data</p>;

  return (
    <div className="max-w-2xl mx-auto">
      <h1 className="text-center font-bold text-[#f8f8f8] text-6xl pt-6 mb-24">
        Your Result
      </h1>
      <div className="flex justify-center bg-[#ffffff2e] text-[#f8f8f8] text-3xl font-bold p-10">
        <p> Your Holland-Code: {data.hollandCode}</p>
      </div>
      <div className="flex justify-center text-[#f8f8f8]">
        <p className="pt-3">
          No idea what this means?
          <Link
            href="/about"
            target="_blank"
            className=" underline underline-offset-2"
          >
            {' '}
            You can read all about here!
          </Link>
        </p>
      </div>
      <div className="pt-10 px-4 text-center">
        <p className="text-[#767171] text-xl italic">
          Based on your personal Holland Code, the following professions could
          be a good match for you:
        </p>

        <div className="bg-[#ffffff2e] my-10">
          <h2 className="text-[#f8f8f8] font-bold text-3xl pt-8 text-center">
            Exact Professions
          </h2>
          <div className="py-6 text-[#767171] text-xl text-center">
            {data.exactProfessions.length > 0 ? (
              data.exactProfessions.map((prof: IProfession) => (
                <p className="pb-2" key={prof.id}>
                  {prof.title} ({prof.hollandCode})
                </p>
              ))
            ) : (
              <p>No exact match</p>
            )}
          </div>
        </div>
        <div className="bg-[#ffffff2e] mb-10">
          <h2 className="text-[#f8f8f8] font-bold text-3xl pt-8 text-center">
            Similar Professions
          </h2>
          <div className="py-6 text-[#767171] text-xl text-center">
            {data.similarProfessions.map((prof: IProfession) => {
              return (
                <p className="pb-2" key={prof.id}>
                  {prof.title} ({prof.hollandCode})
                </p>
              );
            })}
          </div>
        </div>
        <Link href="/tests">
          <button className="fixed left-4 bottom-4 bg-[#f08cc0] text-white px-4 py-2 rounded-lg">
            Back to Tests
          </button>
        </Link>
      </div>
    </div>
  );
}
