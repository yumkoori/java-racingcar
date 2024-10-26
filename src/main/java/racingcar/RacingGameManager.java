package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class RacingGameManager implements RacingGame {
    private final List<Car> racingCarsList = new ArrayList<>();

    @Override
    public void ready(List<String> cars) {
        for (String car : cars) {
            InputValidator.nameValidation(car);

            this.racingCarsList.add(Car.create(car));
        }
    }

    @Override
    public void start(int tryNumber) {
        InputValidator.tryNumberValidation(tryNumber);

        for (int i = 0; i < tryNumber; i++) {
            progressGame();
        }

        endGame();
    }

    private void progressGame() {
        for (Car car : racingCarsList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.movingForward();
            } else {
                car.stop();
            }
        }
        System.out.println();
    }

    private void endGame() {}
}
