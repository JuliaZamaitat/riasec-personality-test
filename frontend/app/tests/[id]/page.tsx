import getQuestions from '../../util/questions';

export default async function Questions({
  params,
}: {
  params: { id: number };
}) {
  const questions = await getQuestions(params.id);

  return (
    <div className="max-w-2xl mx-auto">
      {questions.map((question: any) => {
        return <h1 key={question.id}>{question.text}</h1>;
      })}
    </div>
  );
}
