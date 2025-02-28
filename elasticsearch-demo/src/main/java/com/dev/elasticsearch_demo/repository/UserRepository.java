package com.dev.elasticsearch_demo.repository;

import com.dev.elasticsearch_demo.model.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    /*
    match  --> tam eşleşme, tam metin araması yapar ve kelimeleri parçalayarak arar. eğer geçiyorsa döndürür.
    match_phrase   --> tam cümle eşleşmesi
    match_phrase_prefix    --> tam cümle başlangıcı eşleşmesi
    wildcard   -->  * ve ? gibi özel karakterler kullanarak örüntü (pattern-based) arama yapar.
    regexp   --> regexp, daha karmaşık desenlerle eşleşme yapar.  .* gibi regex ifadelerini destekler.  Performansı düşük olabilir, dikkatli kullanılmalıdır!
    term   --> tam bire bir eşleşme yapar büyük küçük harflere dikkat eder (örneğin mail gibi field aramlarında kullanılabilir)
    terms   --> birden fazla ifadenin bire bir eşleşmesine bakar eğer biri bile uyuyorsa döndürür

    bool -->  bool sorgusu, AND, OR, NOT gibi mantıksal bağlaçları kullanarak farklı koşulları birleştirir. İçinde must, should, must_not, filter gibi operatörler bulunabilir.
    must     → Tüm koşullar sağlanmalı (AND gibi davranır)
    should   → Koşulların en az biri sağlanmalı (OR gibi davranır)
    must_not → Bu koşulu sağlamayanları getirir (NOT gibi davranır)
    filter   → Kesin eşleşmeler için kullanılır, daha hızlıdır ve skor hesaplamaz.
     */


    List<User> findUsersByNameLike(String search);

    // name alanıyla eşleşen userları döndürürüz
    @Query("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
    List<User> findSearchByName(String name);

    // Tüm userlardan name alanı girilen name ile başlayan tüm userları getirir
    @Query("{\"match_phrase_prefix\": {\"name\": \"?0\"}}")
    List<User> findSearchByNameLikeWithNativeQuery(String name);

    // bool kullanılıyorsa içinde direkt mutlak eşleşmeler(match) kullanılamaz.
    // ancak arada must, should gibi bir dizi içermelidir.
    // must --> ve  ,  should ---> veya    ya denk geliyor mantıksal operatorler açısından bakarsak
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}, {\"match\": {\"surname\": \"?1\"}}]}}")
    List<User> findSearchByNameAndSurname(String name, String surname);

    /*
    örneğin sorgumuz aşşağıdaki gibi oluyor
       {
            "bool": {
                "must": [
                    {"match": { "name": "Ali" } },
                    {"match": { "surname": "Yılmaz" } }
                 ]
            }
        }
     */





}
