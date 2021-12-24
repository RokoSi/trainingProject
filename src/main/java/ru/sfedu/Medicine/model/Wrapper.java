package ru.sfedu.Medicine.model;

import org.simpleframework.xml.Root;

    @Root(name = "wrapper")
    public class Wrapper<T> {
/*
        @ElementListUnion({
               @ElementList(entry = "ListPatient", type = ListPatient.class, inline = true),
                @ElementList(entry = "PasssportInform", type = PasssportInform.class, inline = true),
                @ElementList(entry = "Recipe", type = Recipe.class, inline = true),
                @ElementList(entry = "Treatment", type = Treatment.class, inline = true),
                @ElementList(entry = "Analyzes", type = Analyzes.class, inline = true),
                @ElementList(entry = "Complant", type = Complant.class, inline = true),

        })
        private List<T> list;

        public List<T> getList() {
            return list;
        }

        public void setList(List<T> list) {
            this.list = list;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Wrapper)) return false;
            Wrapper<?> wrapper = (Wrapper<?>) o;
            return Objects.equals(list, wrapper.list);
        }

        @Override
        public int hashCode() {
            return Objects.hash(list);
        }

        @Override
        public String toString() {
            return "Wrapper{" +
                    "list=" + list +
                    '}';
        }
    }
*/
    }


