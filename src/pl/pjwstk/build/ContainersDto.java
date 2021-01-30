package pl.pjwstk.build;

import java.io.Serializable;

public class ContainersDto implements Serializable {
    private Container[] containers;

    public ContainersDto(Container[] containers) {
        this.containers = containers;
    }

    public Container[] getContainers() {
        return containers;
    }

    public void setContainers(Container[] containers) {
        this.containers = containers;
    }
}
