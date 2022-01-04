package ru.sfedu.Medicine.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Root;

import java.util.List;
import java.util.Objects;

@Root(name ="User")
public class User<T>{
    private List<T> list;

    @ElementListUnion({
            @ElementList(entry = "ListPatient", type = ListPatient.class, inline = true),
            /*@ElementList(entry = "human", type = Human.class, inline = true),
            @ElementList(entry = "transport", type = Trans.class, inline = true),
            @ElementList(entry = "barrier", type = Barrier.class, inline = true),
            @ElementList(entry = "accessBarrier", type = AccessBarrier.class, inline = true),
            @ElementList(entry = "history", type = History.class, inline = true),
            @ElementList(entry = "motion", type = Motion.class, inline = true),

             */
    })

    public User() {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "User{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User<?> user = (User<?>) o;
        return list.equals(user.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }



}
