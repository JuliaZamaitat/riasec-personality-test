export default async function getTests() {
  let path = '/hollandCodeTests';
  const res = await fetch(process.env.NEXT_PUBLIC_API_URL + path);
  if (!res.ok) {
    throw new Error(`An error has occured: ${res.status}`);
  }
  return res.json();
}
