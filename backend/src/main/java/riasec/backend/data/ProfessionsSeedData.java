package riasec.backend.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import riasec.backend.model.classes.Profession;
import riasec.backend.repository.ProfessionRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessionsSeedData implements CommandLineRunner {
    @Autowired
    ProfessionRepository professionRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Profession> professionsSeedData = new ArrayList<>();

        //Realistic
        professionsSeedData.add(new Profession("Air Traffic Controller", "SER"));
        professionsSeedData.add(new Profession("Archaeologist", "IRE"));
        professionsSeedData.add(new Profession("Athletic Trainer", "SRE"));
        professionsSeedData.add(new Profession("Cartographer", "IRE"));
        professionsSeedData.add(new Profession("Commercial Airline Pilot", "RIE"));
        professionsSeedData.add(new Profession("Commercial Drafter", "IRE"));
        professionsSeedData.add(new Profession("Dental Technician", "REI"));
        professionsSeedData.add(new Profession("Farm Manager", "ESR"));
        professionsSeedData.add(new Profession("Fish and Game Warden", "RES"));
        professionsSeedData.add(new Profession("Floral Designer", "RAE"));
        professionsSeedData.add(new Profession("Forester", "RIS"));
        professionsSeedData.add(new Profession("Geodetic Surveyor", "IRE"));
        professionsSeedData.add(new Profession("Industrial Arts Teacher", "IER"));
        professionsSeedData.add(new Profession("Laboratory Technician", "RIE"));
        professionsSeedData.add(new Profession("Landscape Architect", "AIR"));
        professionsSeedData.add(new Profession("Mechanical Engineer", "RIS"));
        professionsSeedData.add(new Profession("Coptician", "REI"));
        professionsSeedData.add(new Profession("Petroleum Geologist", "RIE"));
        professionsSeedData.add(new Profession("Police Officer", "SER"));
        professionsSeedData.add(new Profession("Practical Nurse", "SER"));
        professionsSeedData.add(new Profession("Property Manager", "ESR"));
        professionsSeedData.add(new Profession("Recreation Manager", "SER"));
        professionsSeedData.add(new Profession("Service Manager", "ERS"));
        professionsSeedData.add(new Profession("Software Technician", "RCI"));
        professionsSeedData.add(new Profession("Ultrasound Technologist", "RSI"));
        professionsSeedData.add(new Profession("Vocational Rehabilitation Consultant", "ESR"));


        //Investigative
        professionsSeedData.add(new Profession("Actuary", "ISE"));
        professionsSeedData.add(new Profession("Agronomist", "IRS"));
        professionsSeedData.add(new Profession("Anesthesiologist", "IRS"));
        professionsSeedData.add(new Profession("Anthropologist", "IRE"));
        professionsSeedData.add(new Profession("Archaeologist", "IRE"));
        professionsSeedData.add(new Profession("Biochemist", "IRS"));
        professionsSeedData.add(new Profession("Biologist", "IRE"));
        professionsSeedData.add(new Profession("Chemical Engineer", "IRE"));
        professionsSeedData.add(new Profession("Chemist", "IRE"));
        professionsSeedData.add(new Profession("Computer Systems Analyst", "IER"));
        professionsSeedData.add(new Profession("Dentist", "ISR"));
        professionsSeedData.add(new Profession("Ecologist", "IRE"));
        professionsSeedData.add(new Profession("Economist", "IAS"));
        professionsSeedData.add(new Profession("Electrical Engineer", "IRE"));
        professionsSeedData.add(new Profession("Geologist", "IRE"));
        professionsSeedData.add(new Profession("Horticulturist", "IRS"));
        professionsSeedData.add(new Profession("Mathematician", "IRE"));
        professionsSeedData.add(new Profession("Medical Technologist", "ISA"));
        professionsSeedData.add(new Profession("Meteorologist", "IRS"));
        professionsSeedData.add(new Profession("Nurse Practitioner", "ISA"));
        professionsSeedData.add(new Profession("Pharmacist", "IES"));
        professionsSeedData.add(new Profession("Physician, General Practice", "ISE"));
        professionsSeedData.add(new Profession("Psychologist", "IES"));
        professionsSeedData.add(new Profession("Research Analyst", "IRC"));
        professionsSeedData.add(new Profession("Statistician", "IRE"));
        professionsSeedData.add(new Profession("Surgeon", "IRA"));
        professionsSeedData.add(new Profession("Technical Writer", "IRS"));
        professionsSeedData.add(new Profession("Veterinarian", "IRS"));


        //Artistic
        professionsSeedData.add(new Profession("Actor", "AES"));
        professionsSeedData.add(new Profession("Advertising Art Director", "AES"));
        professionsSeedData.add(new Profession("Advertising Manager", "ASE"));
        professionsSeedData.add(new Profession("Architect", "AIR"));
        professionsSeedData.add(new Profession("Art Teacher", "ASE"));
        professionsSeedData.add(new Profession("Artist", "ASI"));
        professionsSeedData.add(new Profession("Copy Writer", "ASI"));
        professionsSeedData.add(new Profession("Dance Instructor", "AER"));
        professionsSeedData.add(new Profession("Drama Coach", "ASE"));
        professionsSeedData.add(new Profession("English Teacher", "ASE"));
        professionsSeedData.add(new Profession("Entertainer/Performer", "AES"));
        professionsSeedData.add(new Profession("Fashion Illustrator", "ASR"));
        professionsSeedData.add(new Profession("Interior Designer", "AES"));
        professionsSeedData.add(new Profession("Intelligence Research Specialist", "AEI"));
        professionsSeedData.add(new Profession("Journalist/Reporter", "ASE"));
        professionsSeedData.add(new Profession("Landscape Architect", "AIR"));
        professionsSeedData.add(new Profession("Librarian", "SAI"));
        professionsSeedData.add(new Profession("Medical Illustrator", "AIE"));
        professionsSeedData.add(new Profession("Museum Curator", "AES"));
        professionsSeedData.add(new Profession("Music Teacher", "ASI"));
        professionsSeedData.add(new Profession("Photographer", "AES"));
        professionsSeedData.add(new Profession("Writer", "ASI"));
        professionsSeedData.add(new Profession("Graphic Designer", "AES"));


        //Social
        professionsSeedData.add(new Profession("City Manager", "SEC"));
        professionsSeedData.add(new Profession("Clinical Dietitian", "SIE"));
        professionsSeedData.add(new Profession("College/University Faculty", "SEI"));
        professionsSeedData.add(new Profession("Community Org. Director", "SEA"));
        professionsSeedData.add(new Profession("Consumer Affairs Director", "SER"));
        professionsSeedData.add(new Profession("Counselor/Therapist", "SAE"));
        professionsSeedData.add(new Profession("Historian", "SEI"));
        professionsSeedData.add(new Profession("Hospital Administrator", "SER"));
        professionsSeedData.add(new Profession("Psychologist", "SEI"));
        professionsSeedData.add(new Profession("Insurance Claims Examiner", "SIE"));
        professionsSeedData.add(new Profession("Librarian", "SAI"));
        professionsSeedData.add(new Profession("Medical Assistant", "SCR"));
        professionsSeedData.add(new Profession("Minister/Priest/Rabbi", "SAI"));
        professionsSeedData.add(new Profession("Paralegal", "SCE"));
        professionsSeedData.add(new Profession("Park Naturalist", "SEI"));
        professionsSeedData.add(new Profession("Physical Therapist", "SIE"));
        professionsSeedData.add(new Profession("Police Officer", "SER"));
        professionsSeedData.add(new Profession("Probation and Parole Officer", "SEC"));
        professionsSeedData.add(new Profession("Real Estate Appraiser", "SCE"));
        professionsSeedData.add(new Profession("Recreation Director", "SER"));
        professionsSeedData.add(new Profession("Registered Nurse", "SIA"));
        professionsSeedData.add(new Profession("Teacher", "SAE"));
        professionsSeedData.add(new Profession("Social Worker", "SEA"));
        professionsSeedData.add(new Profession("Speech Pathologist", "SAI"));
        professionsSeedData.add(new Profession("Vocational-Rehab. Counselor", "SEC"));
        professionsSeedData.add(new Profession("Volunteer Services Director", "SEC"));


        //Enterprising
        professionsSeedData.add(new Profession("Advertising Executive", "ESA"));
        professionsSeedData.add(new Profession("Advertising Sales Rep", "ESR"));
        professionsSeedData.add(new Profession("Banker/Financial Planner", "ESR"));
        professionsSeedData.add(new Profession("Branch Manager", "ESA"));
        professionsSeedData.add(new Profession("Business Manager", "ESC"));
        professionsSeedData.add(new Profession("Buyer", "ESA"));
        professionsSeedData.add(new Profession("Chamber of Commerce Exec", "ESA"));
        professionsSeedData.add(new Profession("Credit Analyst", "ESA"));
        professionsSeedData.add(new Profession("Customer Service Manager", "ESA"));
        professionsSeedData.add(new Profession("Education & Training Manager", "EIS"));
        professionsSeedData.add(new Profession("Emergency Medical Technician", "ESI"));
        professionsSeedData.add(new Profession("Entrepreneur", "ESA"));
        professionsSeedData.add(new Profession("Foreign Service Officer", "ESA"));
        professionsSeedData.add(new Profession("Funeral Director", "ESR"));
        professionsSeedData.add(new Profession("Insurance Manager", "ESC"));
        professionsSeedData.add(new Profession("Interpreter", "ESA"));
        professionsSeedData.add(new Profession("Lawyer/Attorney", "ESA"));
        professionsSeedData.add(new Profession("Lobbyist", "ESA"));
        professionsSeedData.add(new Profession("Office Manager", "ESR"));
        professionsSeedData.add(new Profession("Personnel Recruiter", "ESR"));
        professionsSeedData.add(new Profession("Politician", "ESA"));
        professionsSeedData.add(new Profession("Public Relations Rep", "EAS"));
        professionsSeedData.add(new Profession("Retail Store Manager", "ESR"));
        professionsSeedData.add(new Profession("Sales Manager", "ESA"));
        professionsSeedData.add(new Profession("Sales Representative", "ERS"));
        professionsSeedData.add(new Profession("Social Service Director", "ESA"));
        professionsSeedData.add(new Profession("Stockbroker", "ESI"));
        professionsSeedData.add(new Profession("Tax Accountant", "ECS"));


        //Conventional
        professionsSeedData.add(new Profession("Abstractor", "CSI"));
        professionsSeedData.add(new Profession("Accountant", "CSE"));
        professionsSeedData.add(new Profession("Administrative Assistant", "ESC"));
        professionsSeedData.add(new Profession("Budget Analyst", "CER"));
        professionsSeedData.add(new Profession("Business Programmer", "CRI"));
        professionsSeedData.add(new Profession("Business Teacher", "CSE"));
        professionsSeedData.add(new Profession("Catalog Librarian", "CSE"));
        professionsSeedData.add(new Profession("Abstractor", "CSI"));
        professionsSeedData.add(new Profession("Claims Adjuster", "SEC"));
        professionsSeedData.add(new Profession("Computer Operator", "CSR"));
        professionsSeedData.add(new Profession("Congressional-District Aide", "CES"));
        professionsSeedData.add(new Profession("Cost Accountant", "CES"));
        professionsSeedData.add(new Profession("Court Reporter", "CSE"));
        professionsSeedData.add(new Profession("Credit Manager", "ESC"));
        professionsSeedData.add(new Profession("Customs Inspector", "CEI"));
        professionsSeedData.add(new Profession("Editorial Assistant", "CSI"));
        professionsSeedData.add(new Profession("Elementary School Teacher", "SEC"));
        professionsSeedData.add(new Profession("Financial Analyst", "CSI"));
        professionsSeedData.add(new Profession("Insurance Manager", "ESC"));
        professionsSeedData.add(new Profession("Insurance Underwriter", "CSE"));
        professionsSeedData.add(new Profession("Internal Auditor", "ICR"));
        professionsSeedData.add(new Profession("Kindergarten Teacher", "ESC"));
        professionsSeedData.add(new Profession("Medical Records Technician", "CSE"));
        professionsSeedData.add(new Profession("Museum Registrar", "CSE"));
        professionsSeedData.add(new Profession("Paralegal", "SCE"));
        professionsSeedData.add(new Profession("Safety Inspector", "RCS"));
        professionsSeedData.add(new Profession("Tax Accountant", "ECS"));
        professionsSeedData.add(new Profession("Tax Consultant", "CES"));
        professionsSeedData.add(new Profession("Travel Agent", "ECS"));

        for (Profession prof: professionsSeedData) {
            professionRepository.save(prof);
        }
    }
}
