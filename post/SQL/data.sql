TRUNCATE TABLE `post`;

INSERT INTO `post` ( id, title, writer, content )
SELECT
    UUID() AS id,
    CONCAT('제목 ', LPAD(n, 4, '0')) AS title,
    CONCAT('작성자 ', LPAD(n, 4, '0')) AS writer,
    CONCAT('내용 ', LPAD(n, 4, '0')) AS content
FROM
    (
        WITH RECURSIVE seq AS (
            SELECT 1 AS n
            UNION ALL
            SELECT n + 1 FROM seq WHERE n < 1000
        )
        SELECT n FROM seq
    ) AS numbers
;