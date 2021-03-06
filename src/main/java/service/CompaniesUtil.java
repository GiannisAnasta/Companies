package service;

import java.util.*;
import model.Company;
import util.DuplicatesRemoverUtil;

import static util.DuplicatesRemoverUtil.*;

public class CompaniesUtil {

    public static List<Company> getUniqueCompanies(List<Company> companies) {
        Set<Company> unique = new LinkedHashSet<>();

        unique.addAll(companies);

        return new ArrayList(unique);
    }

    public static Company getComapnyWithNoDuplicates(Company entity) {
        Company result = new Company();
        result.setId(entity.getId());
        result.setName(entity.getName());
        result.setSite(removeDuplicates(entity.getSite(), true));
        result.setEmail(removeDuplicates(entity.getEmail(), false));// RFC 5321, section-2.3.11 emails possible case sensitive
        result.setTelephones(removeDuplicates(entity.getTelephones(), false));
        result.setDetails(removeDuplicates(entity.getDetails(), false));
        result.setCategories(removeDuplicates(entity.getCategories(), false));
        return result;
    }

}
