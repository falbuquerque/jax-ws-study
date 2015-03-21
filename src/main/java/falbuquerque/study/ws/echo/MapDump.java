package falbuquerque.study.ws.echo;

import java.util.Map;

public final class MapDump {

    private MapDump() {
        super();
    }
    
    public static void dump(final Map<?, ?> map, final String indent) {
        map.entrySet().forEach(entry -> {
            System.out.println(indent + entry.getKey() + " ==> " + entry.getValue());

            if (entry.getValue() instanceof Map) {
                dump((Map<?, ?>) entry.getValue(), indent + "  ");
            }

        });
    }
    
}
