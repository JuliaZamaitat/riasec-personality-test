'use client';
import Test from './Test';

const TestList: any = ({ tests }: TestListProps) => {
  return (
    <div className="max-w-2xl mx-auto">
      {tests.map((test: any) => {
        return <Test test={test} key={test.id} />;
      })}
    </div>
  );
};

export default TestList;
