'use server';
import getQuestions from '../../../util/questions';
import Quiz from '../../../../components/Quiz';

export default async function QuizQuestions({
  params,
}: {
  params: { test: number };
}) {
  const questions: IQuestion[] = await getQuestions(params.id);

  return (
    <>
      <Quiz testId={params.id} questions={questions} />
    </>
  );
}
