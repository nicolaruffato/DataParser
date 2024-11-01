package Parser;

import Data.Collection;

import java.util.Scanner;

public interface Parser<T extends Collection> {

    T parse(Scanner in);

}
