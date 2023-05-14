'use server';
import getQuestions from '../../util/questions';
import Quiz from '../../../components/Quiz';

export default async function Test({ params }: { params: { id: number } }) {
  const questions: IQuestion[] = await getQuestions(params.id);

  return (
    <>
      <Quiz questions={questions}></Quiz>
    </>
  );
}
