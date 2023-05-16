import Link from 'next/link';

export default async function About() {
  return (
    <div className="max-w-2xl mx-auto">
      <h1 className="text-center font-bold text-[#f8f8f8] text-5xl pt-6 mb-20">
        What are Holland Codes?
      </h1>
      <div className="flex flex-col justify-center bg-[#ffffff2e] text-[#f8f8f8] text-3xl p-10">
        <h2 className="text-center mb-10">RIASEC</h2>
        <p className="text-center ">
          <span className="font-bold">R</span>ealistic{' '}
          <span className="font-bold">I</span>nvestigative{' '}
          <span className="font-bold">A</span>rtistic{' '}
          <span className="font-bold">S</span>ocial{' '}
          <span className="font-bold">E</span>nterprising{' '}
          <span className="font-bold">C</span>onventional
        </p>
      </div>
      <div className="pt-8 px-4">
        <p className="text-[#767171]">
          Holland Codes, based on Dr. John Holland&apos;s theory, categorize
          people and work environments into six different groups. Each letter
          represents one of these groups. Your Holland Code is determined by the
          two or three letters that best match your personality. For example, if
          your code is &quot;RES&quot;, you most resemble the Realistic type,
          followed by Enterprising and then Social. The types not in your code
          are the ones you resemble least. <br></br> <br></br>Most individuals
          and jobs are a combination of two or three Holland interest areas.
          Finding a fit between your personality and work environment leads to
          greater satisfaction. Here you can find further explanations of each
          type, along with career possibilities for each code. For a more
          comprehensive assessment of your Holland Code, you can take one of our
          <Link href="/tests">self-assessment tests</Link>
        </p>

        <h2 className="text-[#f8f8f8] font-bold text-4xl pt-12 text-center">
          The 6 personalities
        </h2>
        <div className="flex flex-col justify-center pt-10">
          <h3 className="text-2xl text-[#f8f8f8]">Realistic (Doers)</h3>
          <p className="pt-5 text-[#767171]">
            People who have athletic ability, prefer to work with objects,
            machines, tools, plants or animals, or to be outdoors.
          </p>
        </div>
        <div className="flex flex-col justify-center pt-10">
          <h3 className="text-2xl text-[#f8f8f8]">Investigative (Thinkers)</h3>
          <p className="pt-5 text-[#767171]">
            People who like to observe, learn, investigate, analyze, evaluate,
            or solve problems.
          </p>
        </div>
        <div className="flex flex-col justify-center pt-10">
          <h3 className="text-2xl text-[#f8f8f8]">Artistic (Creators)</h3>
          <p className="pt-5 text-[#767171]">
            People who have artistic, innovating, or intuitional abilities and
            like to work in unstructured situations using their imagination and
            creativity.
          </p>
        </div>
        <div className="flex flex-col justify-center pt-10">
          <h3 className="text-2xl text-[#f8f8f8]">Social (Helpers)</h3>
          <p className="pt-5 text-[#767171]">
            People who like to work with people to enlighten, inform, help,
            train, or cure them, or are skilled with words.
          </p>
        </div>
        <div className="flex flex-col justify-center pt-10">
          <h3 className="text-2xl text-[#f8f8f8]">Enterprising (Persuaders)</h3>
          <p className="pt-5 text-[#767171]">
            People who like to work with people, influencing, persuading,
            leading or managing for organizational goals or economic gain.
          </p>
        </div>
        <div className="flex flex-col justify-center pt-10 mb-20">
          <h3 className="text-2xl text-[#f8f8f8]">Conventional (Organizers)</h3>
          <p className="pt-5 text-[#767171]">
            People who like to work with data, have clerical or numerical
            ability, carry out tasks in detail, or follow through on
            others&apos; instructions.
          </p>
        </div>

        <Link href="/tests">
          <button className="fixed left-4 bottom-4 bg-[#f08cc0] text-white px-4 py-2 rounded-lg">
            Back to Tests
          </button>
        </Link>
      </div>
    </div>
  );
}
