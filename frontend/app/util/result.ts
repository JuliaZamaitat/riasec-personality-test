export async function getResult(answers: Array<IQuestionAnswers>) {
  const answerMap: Record<number, boolean> = {};

  answers.forEach((answerObj, index) => {
    answerObj.questionAnswers.forEach((answer, question) => {
      const questionId = question.id;
      answerMap[questionId] = answer;
    });
  });

  let path = `/testAttempt`;
  const res = await fetch(process.env.NEXT_PUBLIC_API_URL + path, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      Accept: 'application/json',
    },
    body: JSON.stringify(answerMap),
  });

  if (!res.ok) {
    throw new Error(`An error has occured: ${res.status}`);
  }
  const data = await res.json();
  return data;
}
