export {};

declare global {
  interface ITest {
    id: number;
    title: string;
    description: string;
    version: number;
    testQuestions: IQuestion[];
  }

  interface ITestProps {
    test: ITest;
  }

  interface TestListProps {
    tests: ITest[];
  }

  interface IQuestion {
    text: string;
    personalityType: string;
    id: number;
  }
}
