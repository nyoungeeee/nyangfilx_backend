package com.gamza.nyangflix.domain.tag.endpoint;

import com.gamza.nyangflix.domain.tag.entity.TagForCat;
import com.gamza.nyangflix.domain.tag.service.TagService;
import com.gamza.nyangflix.domain.tag.service.model.TagForCatDto;
import com.gamza.nyangflix.global.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "1. 태그 API", description = "냥플릭스 태그 기능 API. RESTFUL하게 구성되었습니다.")
@RequestMapping("/v1/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping("/")
    @Operation(summary = "태그 리스트", description = "모든 태그를 표시합니다.")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<Response> getAll() {
        return Response.success(tagService.loadAll());
    }

    @GetMapping("/{tagId}")
    @Operation(summary = "태그 조회", description = "tagId로 태그 정보를 조회합니다.")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TagForCat.class)))
    public ResponseEntity<Response> getOne(@PathVariable("tagId") Long tagId) {
        return Response.success(tagService.loadOne(tagId));
    }

    @PostMapping("/")
    @Operation(summary = "태그 생성", description = "태그를 생성합니다.")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<Response> create(@RequestParam String tagName) {
        tagService.createOne(tagName);
        return Response.success("OK");
    }

    @DeleteMapping("/{tagId}")
    @Operation(summary = "태그 삭제", description = "태그를 삭제합니다.")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<Response> delete(@PathVariable("tagId") Long tagId) {
        tagService.deleteOne(tagId);
        return Response.success("OK");
    }

    @PatchMapping("/")
    @Operation(summary = "태그 수정", description = "태그를 수정합니다.")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<Response> modify(@RequestBody List<TagForCatDto> tagForCatDtoList) {
        tagService.update(tagForCatDtoList);
        return Response.success("OK");
    }

    @GetMapping("/keyword")
    @Operation(summary = "태그 검색", description = "키워드로 태그를 검색합니다.")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<Response> search(@RequestParam String keyword) {
        return Response.success(tagService.search(keyword));
    }

}
