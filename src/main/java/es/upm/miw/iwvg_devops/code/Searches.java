package es.upm.miw.iwvg_devops.code;

import java.util.Collection;
import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fraction.getNumerator() < 0 || fraction.getDenominator() < 0))
                .map(User::getFamilyName).distinct();
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isProper))
                .map(User::getId);
    }

    public Fraction findFractionSubtractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .map(user -> user.getFractions())
                .flatMap(Collection::stream)
                .reduce(new Fraction(0, 1), (a, b) -> a.subtract(b));
    }


    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return null;
    }

}
