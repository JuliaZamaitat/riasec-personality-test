export async function sendAnswersToBackend(
  answers: Array<{ [key: string]: string }>
) {
  let path = '/answers';
  try {
    const response = await fetch(process.env.NEXT_PUBLIC_API_URL + path, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(answers),
    });

    if (response.ok) {
      console.log('Answers sent to backend successfully!');
    } else {
      console.error('Failed to send answers to backend:', response.statusText);
    }
  } catch (error) {
    console.error('Error sending answers to backend:', error);
  }
}
