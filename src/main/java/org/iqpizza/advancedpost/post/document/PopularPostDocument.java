package org.iqpizza.advancedpost.post.document;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Getter
@Builder
@AllArgsConstructor
@Document(indexName = "popular-post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Mapping(mappingPath = "elastic/popular-post-mapping.json")
@Setting(settingPath = "elastic/popular-post-setting.json")
public class PopularPostDocument {

    @Id @Field(type = FieldType.Keyword)
    private Long id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String content;

}
