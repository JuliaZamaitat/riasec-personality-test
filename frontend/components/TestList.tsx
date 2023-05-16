'use client';
import Link from 'next/link';
import Test from './Test';

const TestList: any = ({ tests }: TestListProps) => {
  return (
    <div className="max-w-2xl mx-auto">
      {tests.map((test: any) => {
        return <Test test={test} key={test.id} />;
      })}
      <Link href="/about" className="fixed bottom-4 right-4">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          className="h-10 w-10 text-gray-500"
          viewBox="0 0 24 24"
          fill="none"
          stroke="white"
          strokeWidth="2"
          strokeLinecap="round"
          strokeLinejoin="round"
        >
          <circle cx="12" cy="12" r="10" />
          <line x1="12" y1="16" x2="12" y2="12" />
          <line x1="12" y1="8" x2="12" y2="8" />
        </svg>
      </Link>
    </div>
  );
};

export default TestList;
