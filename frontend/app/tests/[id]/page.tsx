export default function Page({ params }: { params: { id: string } }) {
  return <h1>Hello, {params.id}!</h1>;
}
