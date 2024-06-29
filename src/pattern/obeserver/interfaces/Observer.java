package pattern.obeserver.interfaces;

import pattern.obeserver.dto.EventData;

public interface Observer {
    void executeUpdate(EventData data);
}
