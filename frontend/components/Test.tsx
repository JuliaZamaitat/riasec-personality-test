import styles from '../styles/test-list.module.css';

export default function Test(props: ITestProps) {
  const { test } = props;

  return (
    <>
      <h2>{test.title}</h2>
      <p>{test.description}</p>
      <p>{test.version}</p>
    </>
  );
}
