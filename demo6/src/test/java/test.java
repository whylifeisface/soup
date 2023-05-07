import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;

public class test {

    @Test//根据对象创建
    public void createObject(){

        Flux<String> flux = Flux.just("apple", "orange", "banana", "strawberry");
        flux.subscribe(
                f -> System.out.println("Here is some "+ f)
        );
        StepVerifier.create(flux)
                .expectNext("apple")
                .expectNext("orange")
                .expectNext("banana")
                .expectNext("strawberry")
                .verifyComplete();

    }
    @Test //根据集合创建
    public void createList(){
        String[] flux =new String[] {"apple", "orange", "banana", "strawberry"};
        Flux<String> tFlux = Flux.fromArray(flux);
        tFlux.subscribe(
                f -> System.out.println("this is " +f)
        );
        StepVerifier.create(tFlux)
                .expectNext("apple")
                .expectNext("orange")
                .expectNext("banana")
                .expectNext("strawberry")
                .verifyComplete();

    }
}
