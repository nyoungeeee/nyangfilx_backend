package com.gamza.nyangflix.domain.tag.service.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "[TagForCatDto] 태그", description = "고양이용 태그")
public class TagForCatDto {

    @Schema(description = "태그Id")
    private Long tagId;

    @Schema(description = "태그명")
    private String tagName;

}
