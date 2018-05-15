package by.aex.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchHistoryDao {

    private static final SearchHistoryDao INSTANCE = new SearchHistoryDao();

    public static SearchHistoryDao getInstance() {
        return INSTANCE;
    }
}
