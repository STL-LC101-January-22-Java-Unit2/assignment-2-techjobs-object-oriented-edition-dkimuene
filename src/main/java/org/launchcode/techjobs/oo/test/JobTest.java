package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job job1;
    Job job2;
    Job job3;
    Job job4;
    Job job5;


    @Before
    public void createJobObjects(){
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        job5 = new Job("Product tester", new Employer(""),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency(""));
    }

    @Test
    public void testSettingJobID(){
        assertFalse(job1.getId()== job2.getId());
        assertTrue((job1.getId()+ job2.getId())%2==1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job3.getName(),"Product tester");
        assertEquals(job3.getEmployer().getValue(),"ACME");
        assertEquals(job3.getLocation().getValue(),"Desert");
        assertEquals(job3.getPositionType().getValue(),"Quality control");
        assertEquals(job3.getCoreCompetency().getValue(),"Persistence");
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(job3.equals(job4));
    }

    @Test
    public void testTheToStringMethodForFirstAndLastLinesBlank(){
        String info = job3.toString();
        String[] infoLine = info.split("");
        assertTrue(infoLine[0].equals("\n"));
        assertTrue(infoLine[infoLine.length-1].equals("\n"));
    }

    @Test
    public void testTheToStringMethodForEachFieldLabel(){
        String info = job3.toString();
        String[] infoLine = info.split("\n");

        assertTrue(infoLine[1].equals("ID: "+job3.getId()));
        assertTrue(infoLine[2].equals("Name: Product tester"));
        assertTrue(infoLine[3].equals("Employer: ACME"));
        assertTrue(infoLine[4].equals("Location: Desert"));
        assertTrue(infoLine[5].equals("Position Type: Quality control"));
        assertTrue(infoLine[6].equals("Core Competency: Persistence"));
    }

    @Test
    public void testTheToStringMethodForEmptyData(){
        String info = job5.toString();
        String[] infoLine = info.split("\n");
        assertTrue(infoLine[1].equals("ID: "+job5.getId()));
        assertTrue(infoLine[2].equals("Name: Product tester"));
        assertTrue(infoLine[3].equals("Employer: Data not available"));
        assertTrue(infoLine[4].equals("Location: Desert"));
        assertTrue(infoLine[5].equals("Position Type: Quality control"));
        assertTrue(infoLine[6].equals("Core Competency: Data not available"));

    }
}
