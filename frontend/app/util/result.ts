export async function getResult(
  testId: number,
  answers: Array<IQuestionAnswers>
) {
  const answerMap: Record<number, boolean> = {};

  answers.forEach((answerObj, index) => {
    answerObj.questionAnswers.forEach((answer, question) => {
      const questionId = Number(question.id);
      answerMap[questionId] = answer;
    });
  });

  const user = {
    email: localStorage.getItem('email'),
    firstName: localStorage.getItem('firstName'),
    lastName: localStorage.getItem('lastName'),
    gender: localStorage.getItem('gender'),
  };

  let path = `/testAttempt`;
  const res = await fetch(process.env.NEXT_PUBLIC_API_URL + path, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      Accept: 'application/json',
    },
    body: JSON.stringify({
      testId: testId,
      questionAnswer: answerMap,
      user: user,
    }),
  });

  if (!res.ok) {
    throw new Error(`An error has occured: ${res.status}`);
  }
  const data = await res.json();
  return data;
}
