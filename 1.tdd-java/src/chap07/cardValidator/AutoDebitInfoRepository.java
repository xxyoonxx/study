package cardValidator;

public interface AutoDebitInfoRepository {

    void save(AutoDebitInfo info);
    AutoDebitInfo findOne(String userId);

}
