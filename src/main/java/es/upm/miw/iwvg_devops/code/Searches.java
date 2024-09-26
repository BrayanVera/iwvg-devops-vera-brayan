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
        //bug#11
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .map(User::getFractions)
                .flatMap(Collection::stream)
                .reduce(new Fraction(0, 1), Fraction::subtract);
    }

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {

        System.out.println("Hola");
        return new UsersDatabase().findAll()
                .filter(user -> user.getFamilyName().equals(familyName))
                .map(User::getFractions)
                .flatMap(Collection::stream)
                .reduce(new Fraction(1, 1),Fraction::multiply);
    }

}
