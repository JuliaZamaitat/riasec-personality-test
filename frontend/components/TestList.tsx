// import styles from '../styles/test-list.module.css';
'use client';
import Test from './Test';

const TestList: any = ({ tests }: TestListProps) => {
  return (
    <>
      {tests.map((test: any) => {
        return <Test test={test} key={test.id} />;
      })}
    </>
  );
};

export default TestList;
