package ladder;

import static ladder.Direction.*;

public class Row {
    private final int[] row;

    public Row(GreaterThanOne numberOfPerson) {
        row = new int[numberOfPerson.getNumber()];
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        setDirectionAtPosition(startPosition, RIGHT);
        startPosition.next();
        setDirectionAtPosition(startPosition, LEFT);
    }

    private void setDirectionAtPosition(Position startPosition, Direction direction) {
        row[startPosition.getValue()] = direction.getValue();
    }

    public void nextPosition(Position position) {
        validatePosition(position);

        if (isRight(position)) {
            position.next();
            return;
        }
        if (isLeft(position)) {
            position.prev();
            return;
        }

    }

    private boolean isLeft(Position position) {
        return row[position.getValue()] == LEFT.getValue();
    }

    private boolean isRight(Position position) {
        return row[position.getValue()] == RIGHT.getValue();
    }

    private void validatePosition(Position position) {
        if (isInvalidPosition(position) ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        validatePosition(startPosition);
        if (isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(row.length - 1) ;
    }

    private boolean isLineAtPosition(Position position) {
        return row[position.getValue()] != NONE.getValue();
    }

    private boolean isLineAtNextPosition(Position position) {
        return row[position.getValue() + 1] == RIGHT.getValue();
    }

}