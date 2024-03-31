package com.gamza.nyangflix.domain.tag.endpoint;

import com.gamza.nyangflix.domain.tag.service.TagService;
import com.gamza.nyangflix.global.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Response> getOne(@PathVariable("tagId") Long id) {
        return Response.success("");
    }

    @PostMapping("/")
    public ResponseEntity<Response> create(@RequestParam String tagName) {
        tagService.createOne(tagName);
        return Response.success("OK");
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<Response> delete(@PathVariable("tagId") Long id) {
        return Response.success("OK");
    }

    @PatchMapping("/")
    public ResponseEntity<Response> modify() {
        return Response.success("OK");
    }

    @GetMapping("/check")
    public ResponseEntity<Response> checkIsValid(@Param("tagName") String tagName) {
        return Response.success("");
    }


}
