package org.launchcode.techjobs.oo.test;

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

    Job job1 = new Job();
    Job job2 = new Job();
    Job job3 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
    Job job4 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
    Job job5 = new Job("", new Employer(""),
                new Location(""), new PositionType(""),
                new CoreCompetency(""));


    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.getId()== job2.getId());
//        assertTrue((job1.getId()+ job2.getId())%2==1);
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
    public void testToStringStartsAndEndsWithNewLine(){
        String info = job3.toString();
        char firstChar = job3.toString().charAt(0);
        char lastChar = job3.toString().charAt(job3.toString().length()-1);
        assertEquals('\n',firstChar);
        assertEquals('\n',lastChar);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String info = job3.toString();
        String[] infoLine = info.split("\n");

        assertEquals("ID: "+job3.getId(),infoLine[1]);
        assertEquals("Name: Product tester",infoLine[2]);
        assertEquals("Employer: ACME", infoLine[3]);
        assertEquals("Location: Desert", infoLine[4]);
        assertEquals("Position Type: Quality control", infoLine[5]);
        assertEquals("Core Competency: Persistence", infoLine[6]);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        String info = job5.toString();
        String[] infoLine = info.split("\n");
        assertEquals("ID: "+job5.getId(),infoLine[1]);
        assertEquals("Name: Data not available",infoLine[2]);
        assertEquals("Employer: Data not available", infoLine[3]);
        assertEquals("Location: Data not available", infoLine[4]);
        assertEquals("Position Type: Data not available", infoLine[5]);
        assertEquals("Core Competency: Data not available", infoLine[6]);
    }
}
