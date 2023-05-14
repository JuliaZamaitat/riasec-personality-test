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

  interface IQuizProps {
    questions: IQuestion[];
    testId: number;
  }

  interface TestListProps {
    tests: ITest[];
  }

  interface IQuestion {
    text: string;
    personalityType: string;
    id: number;
  }

  interface IQuestionAnswers {
    questionAnswers: Map<IQuestion, boolean>;
  }
  interface IProfession {
    id: number;
    title: string;
    hollandCode: string;
  }

  interface IData {
    hollandCode: string;
    exactProfessions: IProfession[];
    similarProfessions: IProfession[];
  }
}
