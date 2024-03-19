import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSimpleRegexMatches {
    public static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;

        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    // 정규식이 "foo"이고 입력 문자열이 "foo"이면, 일치가 성공합니다
    @Test
    public void givenText_whenSimpleRegexMatches_thenCorre() {
        String source = "foo";
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher(source);

        assertTrue(matcher.find());
    }

    @Test
    public void givenText_whenSimpleRegexMatchesTwice_thenCorret() {
        String source = "foofoo";
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher(source);

        int matches = 0;
        while (matcher.find()) {
            matches++;
        }

        assertEquals(2, matches);
    }

    // 메타 문자는 패턴이 일치하는 방식에 영향을 미치며, 어떤 의미로는 검색 패턴에 논리를 추가합니다. Java API는 여러 메타 문자를
    // 지원하며, 가장 간단한 것은 점 "."으로 모든 문자와 일치합니다.
    @Test
    public void givenText_whenMatchesWithDotMetach_thenCorrect() {
        int matches = runTest(".", "foo");

        assertTrue(matches > 0);
    }

    // a, b, c로 시작하는 문자열이 있다.
    @Test
    public void givenORset_whenMatchesAny_theCorret() {
        int matches = runTest("[abc]", "b");
        assertEquals(1, matches);
    }

    // b, c, r로 시작하는 문자열이 있다
    @Test
    public void givenORset_whenMatchesAllCombinations_thenCorrect() {
        int matches = runTest("[bcr]at", "batcatrat");

        assertEquals(3, matches);
    }

    // a, b, c를 제외한 문자가 있다.
    @Test
    public void givenNORSet_whenMatchesNon_thenCorrec() {
        int matcges = runTest("[^abc]", "ag");

        assertTrue(matcges > 0);
    }

    // A 부터 Z까지의 문자중 존재하는 문자의 개수
    @Test
    public void givenUpperCaseRange_whenMatchesUpperCase_thenCorret() {
        int matches = runTest("[A-Z]", "Two Uppercase A alphabets 34 overall");

        assertEquals(3, matches);
    }

    // a부터 z까지의 문자중 존재하는 문자의 개수
    @Test
    public void givenLoweCaseRange_whenMatcghesLowerCase_thenCorretc() {
        int matches = runTest("[a-z]", "Two Uppercase A alphabets 34 overall");

        assertEquals(26, matches);
    }

    // 대소문자를 구분하지않고 알파벳의 문자중 존재하는 문자의 개수
    // z-a는 오류가 남 무저건 작은 것부터 큰서 순서대로 작성해줘야함
    @Test
    public void ginvenBothLowerAndUppercase_thenCorrect() {
        int matches = runTest("[A-Za-z]", "Two Uppercase A alphabets 34 overall");

        assertEquals(29, matches);
    }

    @Test
    public void givenNumberRange_whenMatchesAccurately_thenCorrect() {
        int matches = runTest("[1-5]", "Two Uppercase A alphabets 34 overall");

        assertEquals(2, matches);
    }

    // 합집합 [1-37-9]와도 똑같음
    @Test
    public void givenTwoSets_whenMatchesUnion_thenCorrect() {
        int matches = runTest("[1-3[7-9]]", "123456789");

        assertEquals(6, matches);
    }

    // 교집합
    @Test
    public void geinTwoSets_whenMatchesIntersection_ThenCorret() {
        int matches = runTest("[1-6&&[3-9]]", "123456789");

        assertEquals(4, matches);
    }

    // 차집합
    @Test
    public void givenSetWithSubtraction_whenMatchesAccurately_thenCorrect() {
        int matches = runTest("[0-9&&[^2468]]", "123456789");

        assertEquals(5, matches);
    }

    // 숫자와 일치시키기, [0-9]와 동등
    @Test
    public void givenDigits_whenMatches_thenCorrect() {
        int matches = runTest("\\d", "123");

        assertEquals(matches, 3);
    }

    // 숫자가 아닌 것과 일치시키기, [^0-9]와 동등합니다:
    @Test
    public void givenNonDigits_whenMatches_thenCorrect() {
        int matches = runTest("\\D", "a6c");

        assertEquals(matches, 2);
    }

    // 공백과 일치시키기
    @Test
    public void givenWhiteSpace_whenMatches_thenCorrect() {
        int matches = runTest("\\s", "a c");

        assertEquals(matches, 1);
    }

    // 공백이 아닌것과 일치시키기
    @Test
    public void givenNonWhiteSpace_whenMatches_thenCorrect() {
        int matches = runTest("\\S", "a c");

        assertEquals(matches, 2);
    }

    // 단어 문자와 일치시키기, [a-zA-Z_0-9]와 동등합니다
    @Test
    public void givenWordCharacter_whenMatches_thenCorrect() {
        int matches = runTest("\\w", "hi!");

        assertEquals(matches, 2);
    }

    // 단어 문자가 아닌 것과 일치시키기
    @Test
    public void givenNonWordCharacter_whenMatches_thenCorrect() {
        int matches = runTest("\\W", "hi!");

        assertEquals(matches, 1);
    }

    // 이는 일치의 임계값이 하나입니다. 필요한 문자열이 전혀 나타나지 않으면 일치가 없으며 빈 문자열조차도 없습니다
    @Test
    public void givenOneOrManyQunatifier_whenMatches_thenCorrect() {
        int matches = runTest("\\a+", "hi");

        assertFalse(matches > 0);
    }

    // 중괄호 구문을 사용하여 특정 텍스트를 일정 횟수만큼 일치시킬 수 있습니다
    @Test
    public void givenBraceQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("a{3}", "aaaaaa");

        assertEquals(matches, 2);
    }

    // 텍스트가 두 번 연속하여 나타나지 않기 때문에 일치가 발생하지 않습니다:
    @Test
    public void givenBraceQuantifier_whenFailsToMatch_thenCorrect() {
        int matches = runTest("a{3}", "aa");

        assertFalse(matches > 0);
    }

    // 긴걸 우선적으로 확인하므로 aaa만 인식하여 1번만 인식된다.
    // 여기서는 최소 두 번 발생하되 세 번을 초과하지 않도록 지정했으므로 matcher는 하나의 일치만 발견하게 됩니다. matcher는 단일한
    // aaa와 나머지 a를 발견할 수 없기 때문입니다.
    @Test
    public void givenBraceQuantifierWithRange_whenMatches_thenCorrect() {
        int matches = runTest("a{2,3}", "aaaa");

        assertEquals(matches, 1);
    }

    // 다른 반복 횟수에 대해서도 백 레퍼런싱을 사용하여 매처가 입력을 단일 매치로 보도록 만들 수 있습니다
    @Test
    public void givenCapturingGroup_whenMatchesWithBackReference_thenCorrect2() {
        int matches = runTest("(\\d\\d)\\1\\1\\1", "12121212");

        assertEquals(1, matches);
    }

    // ^은 문장의 시작을 뜻함
    @Test
    public void givenText_whenMatchesAtzbeginning_tehenCorrect() {
        int matches = runTest("^dog", "dogs are frriendly");

        assertTrue(matches > 0);
    }

    @Test
    public void givenText_whenMatchesAtzbeginning_tehenCorrect2() {
        int matches = runTest("^dog", "are dogs frriendly");

        assertFalse(matches > 0);
    }

    // 텍스트의 끝 부분에서만 필수적인 정규식이 일치할 때만 일치하도록 하려면 달러 기호 $를 사용합니다. 다음 경우에는 일치하는 항목을 찾을 수 있습니다
    @Test
    public void givenText_whenMatchesAtEnd_thenCorrect() {
        int matches = runTest("dog$", "Man's best friend is a dog");

        assertTrue(matches > 0);
    }

    @Test
    public void givenTextAndWrongInput_whenMatchFailsAtEnd_thenCorrect() {
        int matches = runTest("dog$", "is a dog man's best friend?");

        assertFalse(matches > 0);
    }

    // 필수 텍스트가 단어 경계에 있는 경우에만 일치하도록 하려면 정규식의 시작과 끝에 \\b 정규식을 사용합니다
    // 빈 문자열은 텍스트의 시작 부분에서도 단어 경계입니다
    @Test
    public void givenText_whenMatchesAtWordBoundary_thenCorrect(){
        int matches = runTest("\\bdog\\b", "a dog is friendly");

        assertTrue(matches > 0);
    }

    // 10자리 정수를 추출하는 것
    @Test
    public void givenInteger_whenMatches10degit_thenCorrect(){

        String regex = "\\b[+-]?(0|[1-9][0-9]{0,9})\\b";
        assertEquals(1, runTest(regex, "0"));
        assertEquals(1, runTest(regex, "1"));
        assertEquals(1, runTest(regex, "123"));
        assertEquals(0, runTest(regex, "12345678901"));
        assertEquals(1, runTest(regex, "+0"));
        assertEquals(1, runTest(regex, "+01"));
        assertEquals(1, runTest(regex, "+1"));
        assertEquals(1, runTest(regex, "+123"));
        assertEquals(0, runTest(regex, "+12345678901"));
        assertEquals(1, runTest(regex, "-0"));
        assertEquals(1, runTest(regex, "-1"));
        assertEquals(1, runTest(regex, "-01"));
        assertEquals(1, runTest(regex, "-123"));
        assertEquals(0, runTest(regex, "-12345678901"));
    }


}
