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
        professionsSeedData.add(new Profession("Corrections Officer", "SER"));

        //Investigative
        professionsSeedData.add(new Profession("Actuary", "ISE"));
        professionsSeedData.add(new Profession("Agronomist", "IRS"));
        professionsSeedData.add(new Profession("Anesthesiologist", "IRS"));
        professionsSeedData.add(new Profession("Anthropologist", "IRE"));
        professionsSeedData.add(new Profession("Archaeologist", "IRE"));
        professionsSeedData.add(new Profession("Biochemist", "IRS"));
        professionsSeedData.add(new Profession("Biologist", "IRE"));


        //Artistic
        professionsSeedData.add(new Profession("Actor", "AES"));
        professionsSeedData.add(new Profession("Advertising Art Director", "AES"));
        professionsSeedData.add(new Profession("Advertising Manager", "ASE"));
        professionsSeedData.add(new Profession("Architect", "AIR"));
        professionsSeedData.add(new Profession("Art Teacher", "ASE"));
        professionsSeedData.add(new Profession("Artist", "ASI"));


        //Social
        professionsSeedData.add(new Profession("City Manager", "SEC"));
        professionsSeedData.add(new Profession("Clinical Dietitian", "SIE"));
        professionsSeedData.add(new Profession("College/University Faculty", "SEI"));
        professionsSeedData.add(new Profession("Community Org. Director", "SEA"));
        professionsSeedData.add(new Profession("Consumer Affairs Director", "SER"));
        professionsSeedData.add(new Profession("Counselor/Therapist", "SAE"));

        //Enterprising
        professionsSeedData.add(new Profession("Advertising Executive", "ESA"));
        professionsSeedData.add(new Profession("Advertising Sales Rep", "ESR"));
        professionsSeedData.add(new Profession("Banker/Financial Planner", "ESR"));
        professionsSeedData.add(new Profession("Branch Manager", "ESA"));
        professionsSeedData.add(new Profession("Business Manager", "ESC"));
        professionsSeedData.add(new Profession("Buyer", "ESA"));
        professionsSeedData.add(new Profession("Chamber of Commerce Exec", "ESA"));

        //Conventional
        professionsSeedData.add(new Profession("Abstractor", "CSI"));
        professionsSeedData.add(new Profession("Accountant", "CSE"));
        professionsSeedData.add(new Profession("Administrative Assistant", "ESC"));
        professionsSeedData.add(new Profession("Budget Analyst", "CER"));
        professionsSeedData.add(new Profession("Business Programmer", "CRI"));
        professionsSeedData.add(new Profession("Business Teacher", "CSE"));
        professionsSeedData.add(new Profession("Catalog Librarian", "CSE"));


        for (Profession prof: professionsSeedData) {
            professionRepository.save(prof);
        }
    }
}
