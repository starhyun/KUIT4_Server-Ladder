package ladder;

import ladder.creator.LadderCreator;

public class Ladder {

    private final LadderCreator ladderCreator;

    public Ladder(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);
        return position.getValue();
    }
}
