export default async function getQuestions(id: number) {
  let path = `/hollandCodeTests/${id}`;
  const res = await fetch(process.env.NEXT_PUBLIC_API_URL + path);
  if (!res.ok) {
    throw new Error(`An error has occured: ${res.status}`);
  }
  const data = await res.json();
  return data.testQuestions;
}
