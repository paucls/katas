package com.katas;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TextStatementPresenterTest {

    private TextStatementPresenter statementPresenter;

    @Before
    public void setUp() {
        statementPresenter = new TextStatementPresenter();
    }

    @Test
    public void printStatement_when_no_lines_prints_only_the_header() {
        // When
        String statement = statementPresenter.printStatement(Collections.emptyList());

        // Then
        assertThat(statement).isEqualTo("Date  Amount  Balance");
    }

    @Test
    public void printStatement_when_one_line_prints_it() {
        // Given
        List<StatementLine> statementLines = Collections.singletonList(
                new StatementLine(LocalDate.of(2017, 12, 6), 500, 500)
        );

        // When
        String statement = statementPresenter.printStatement(statementLines);

        // Then
        assertThat(statement).isEqualTo("Date  Amount  Balance" +
                "\n2017-12-06  +500  500");
    }

    @Test
    public void printStatement_when_multiple_lines_prints_multiple_lines() {
        List<StatementLine> statementLines = Arrays.asList(
                new StatementLine(LocalDate.of(2017, 10, 25), 500, 500),
                new StatementLine(LocalDate.of(2017, 10, 25), 400, 900)
        );

        // When
        String statement = statementPresenter.printStatement(statementLines);

        // Then
        assertThat(statement).isEqualTo("Date  Amount  Balance" +
                "\n2017-10-25  +500  500" +
                "\n2017-10-25  +400  900");
    }

}
