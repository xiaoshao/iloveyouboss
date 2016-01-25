package iloveyouboss;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by ctuo on 1/19/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProfileTest {

    Profile testProfile = new Profile("test profile");
    Criteria testCriteria = new Criteria();
    Question testQuestion = new BooleanQuestion(1,"test boolean question");
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void when_criteria_empte_return_false() throws Exception {

        //assertThat(testProfile.matches(testCriteria),is(false));
        assertEquals("result should be false!",false,testProfile.matches(testCriteria));
    }
    @Test
    public void when_weight_notcare_return_true() throws Exception {
        Answer testAnswer = new Answer(testQuestion,1);
        Weight testWeight = Weight.DontCare;
        Criterion testCriterion = new Criterion(testAnswer,testWeight);
        testCriteria.add(testCriterion);
        assertEquals("result should be true!",true,testProfile.matches(testCriteria));
    }
    @Test
    public void when_criterion_weight_mustmatch_answermatch_true_return_true() throws Exception {
        //set answer.match(criterion.getAnswer()) to be true
        Answer testAnswer1 = new Answer(testQuestion,2);
        Answer testAnswer2 = new Answer(testQuestion,2);
        testProfile.add(testAnswer2);
        //set criterion.getWeight() == Weight.MustMatch
        Weight testWeight = Weight.MustMatch;
        Criterion testCriterion = new Criterion(testAnswer1,testWeight);

        testCriteria.add(testCriterion);
        assertEquals("result should be true!",true,testProfile.matches(testCriteria));
    }
    @Test
    public void when_criterion_weight_import_answermatch_true_return_false() throws Exception {
        //set answer.match(criterion.getAnswer()) to be false
        Answer testAnswer1 = new Answer(testQuestion,1);
        Answer testAnswer2 = new Answer(testQuestion,2);
        testProfile.add(testAnswer2);
        //set criterion.getWeight() == Weight.Important
        Weight testWeight = Weight.Important;
        Criterion testCriterion = new Criterion(testAnswer1,testWeight);

        testCriteria.add(testCriterion);
        assertEquals("result should be false!",false,testProfile.matches(testCriteria));

    }
    @Test
    public void when_criterion1_and_criterion2_weight_notcare_return_true() throws Exception{
        //new criterion1
        Answer testAnswer1 = new Answer(testQuestion,1);
        Weight testWeight1 = Weight.DontCare;
        Criterion testCriterion1 = new Criterion(testAnswer1,testWeight1);
        //new criterion2
        Answer testAnswer2 = new Answer(testQuestion,2);
        Weight testWeight2 = Weight.DontCare;
        Criterion testCriterion2 = new Criterion(testAnswer2,testWeight2);

        testCriteria.add(testCriterion1);
        testCriteria.add(testCriterion2);

        assertEquals("result should be true!",true,testProfile.matches(testCriteria));
    }
    @Test
    public void when_criterion1_notcare_criterion2_answermatch_false_getweight_mustmatch_return_false() throws Exception {
        //new criterion1
        Answer testAnswer1 = new Answer(testQuestion,1);
        Weight testWeight1 = Weight.DontCare;
        Criterion testCriterion1 = new Criterion(testAnswer1,testWeight1);
        //new criterion2
        //set answer.match(criterion.getAnswer()) to be false
        Answer testAnswer2_1 = new Answer(testQuestion,1);
        Answer testAnswer2_2 = new Answer(testQuestion,2);
        testProfile.add(testAnswer2_2);
        //set criterion.getWeight() == Weight.MustMatch
        Weight testWeight = Weight.MustMatch;
        Criterion testCriterion2 = new Criterion(testAnswer2_1,testWeight);

        testCriteria.add(testCriterion1);
        testCriteria.add(testCriterion2);

        assertEquals("result should be false!",false,testProfile.matches(testCriteria));

    }
    @Test
    public void when_criterion1_notcare_criterion2_answermatch_false_getweight_notmustmatch_return_true() throws Exception {
        //new criterion1
        Answer testAnswer1 = new Answer(testQuestion,1);
        Weight testWeight1 = Weight.DontCare;
        Criterion testCriterion1 = new Criterion(testAnswer1,testWeight1);
        //new criterion2
        //set answer.match(criterion.getAnswer()) to be false
        Answer testAnswer2_1 = new Answer(testQuestion,1);
        Answer testAnswer2_2 = new Answer(testQuestion,2);
        testProfile.add(testAnswer2_2);
        //set criterion.getWeight() == Weight.VeryImportant
        Weight testWeight = Weight.VeryImportant;
        Criterion testCriterion2 = new Criterion(testAnswer2_1,testWeight);

        testCriteria.add(testCriterion1);
        testCriteria.add(testCriterion2);

        assertEquals("result should be true!",true,testProfile.matches(testCriteria));

    }
    @Test
    public void when_criterion1_other_answermatch_false_getweight_mustmatch_criterion2_notcare_return_true() throws Exception {
        //new criterion1
        //set criterion.getWeight() == Weight.VeryImportant
        Weight testWeight1 = Weight.Important;
        //set answer.match(criterion.getAnswer()) to be false
        Answer testAnswer1_1 = new Answer(testQuestion,1);
        Answer testAnswer1_2 = new Answer(testQuestion,2);
        testProfile.add(testAnswer1_2);
        Criterion testCriterion1 = new Criterion(testAnswer1_2,testWeight1);
        //new criterion2
        //set criterion.getWeight() == Weight.DontCare
        Weight testWeight = Weight.DontCare;
        Answer testAnswer2 = new Answer(testQuestion,2);
        Criterion testCriterion2 = new Criterion(testAnswer2,testWeight);

        testCriteria.add(testCriterion1);
        testCriteria.add(testCriterion2);

        assertEquals("result should be true!",true,testProfile.matches(testCriteria));

    }
}