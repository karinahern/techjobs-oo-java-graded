package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import javax.naming.Name;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    private Job job1, job2, job3, job4, job5;

    @Before
    public void createJob(){
       job1 = new Job();
       job2 = new Job();
       job3 = new Job("Product tester", new Employer("ACME"),
               new Location("Desert"), new PositionType("Quality control"),
               new CoreCompetency("Persistence"));
       job4 = new Job("Front End Developer", new Employer("Boeing"),
               new Location("St.Louis"), new PositionType("Developer"),
               new CoreCompetency("Optimization"));
       job5 = new Job("Front End Developer", new Employer("Boeing"),
               new Location("St.Louis"), new PositionType("Developer"),
               new CoreCompetency("Optimization"));
    }

    @Test
    public void testSettingJobId(){
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals(job3.getName(), "Product tester");
        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(), "Quality control");
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");

        assertTrue(job3.getName() == "Product tester");
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }


    @Test
    public void testJobsForEquality(){
        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        String firstLine = job4.toString().substring(0,0);
        String lastLine = job4.toString().substring
                (job4.toString().length()-2, job4.toString().length()-2);
        assertEquals(firstLine, lastLine);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String output =
                "\nID: " + job3.getId() +
                "\nName: " + job3.getName() +
                "\nEmployer: " + job3.getEmployer() +
                "\nLocation: " + job3.getLocation() +
                "\nPosition Type: " + job3.getPositionType() +
                "\nCore Competency: " + job3.getCoreCompetency();
        assertEquals(output, job3.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        job3.getEmployer().setValue("");
        job3.getLocation().setValue("");

        String output = "\nID: " + job3.getId() +
                        "\nName: " + job3.getName() +
                        "\nEmployer: Data not available" +
                        "\nLocation: Data not available"  +
                        "\nPosition Type: " + job3.getPositionType() +
                        "\nCore Competency: " + job3.getCoreCompetency();
        assertEquals(output, job3.toString());
    }
}
