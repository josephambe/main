package seedu.address.logic.parser;

import static org.junit.Assert.assertEquals;

import static seedu.address.testutil.TypicalModules.ASKING_QUESTIONS;
import static seedu.address.testutil.TypicalModules.DISCRETE_MATH;

import org.junit.Test;

import seedu.address.logic.commands.AddModuleCommand;
import seedu.address.logic.commands.DeleteModuleCommand;
import seedu.address.logic.commands.EditModuleCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.testutil.ModuleUtil;

//@@author alexkmj
/**
 * Unit testing for {@code TranscriptParser}.
 * <p>
 * Tests for the following:
 * <ul>
 *     <li>Add module command</li>
 *     <li>Delete module command</li>
 *     <li>Edit module command</li>
 * </ul>
 */
public class TranscriptParserTest {

    /**
     * {@code TranscriptParser} used for all tests in {@TranscriptParserTest}.
     */
    private final TranscriptParser parser = new TranscriptParser();

    /**
     * Tests for add module command.
     *
     * @throws ParseException parse exception that should not be thrown
     */
    @Test
    public void parseCommandAddModule() throws ParseException {
        AddModuleCommand addModuleCommand = new AddModuleCommand(DISCRETE_MATH);
        String addModuleString = ModuleUtil.getAddModuleCommand(DISCRETE_MATH);
        AddModuleCommand command = (AddModuleCommand) parser
                .parseCommand(addModuleString);
        assertEquals(addModuleCommand, command);
    }

    /**
     * Test for delete module command.
     *
     * @throws ParseException parse exception that should not be thrown
     */
    @Test
    public void parseCommandDeleteModule() throws ParseException {
        DeleteModuleCommand deleteModuleCommand =
                new DeleteModuleCommand(DISCRETE_MATH.getCode());
        String deleteModuleString = ModuleUtil
                .getDeleteModuleCommand(DISCRETE_MATH);
        DeleteModuleCommand command = (DeleteModuleCommand) parser
                .parseCommand(deleteModuleString);
        assertEquals(deleteModuleCommand, command);
    }

    /**
     * Test for edit module command.
     *
     * @throws ParseException
     */
    @Test
    public void parseCommandEditModule() throws ParseException {
        EditModuleCommand editModuleCommand = new EditModuleCommand(
                DISCRETE_MATH.getCode(),
                DISCRETE_MATH.getYear(),
                DISCRETE_MATH.getSemester(),
                ASKING_QUESTIONS.getCode(),
                null,
                null,
                null,
                null
        );
        String editModuleString = ModuleUtil
                .getEditModuleCommand(DISCRETE_MATH,
                        ASKING_QUESTIONS.getCode(),
                        null,
                        null,
                        null,
                        null);
        EditModuleCommand command = (EditModuleCommand) parser
                .parseCommand(editModuleString);
        assertEquals(editModuleCommand, command);
    }
}
