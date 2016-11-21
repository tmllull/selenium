package testPackage;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class SiFallaLaPrueba extends TestWatcher {
    @Override
    protected void failed(Throwable e, Description descripcion) {
        System.out.println("Si la prueba falla se ejecuta esto");
    }
}