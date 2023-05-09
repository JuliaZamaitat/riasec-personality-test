export {};

declare global {
  interface ITest {
    id: number;
    title: string;
    description: string;
    version: number;
  }

  interface ITestProps {
    test: ITest;
  }

  interface TestListProps {
    tests: ITest[];
  }
}
