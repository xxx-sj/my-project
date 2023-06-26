package com.demo.myproject.service.posts;

import com.demo.myproject.dto.posts.PostsResponseDto;
import com.demo.myproject.dto.posts.PostsSaveRequestDto;
import com.demo.myproject.dto.posts.PostsUpdateRequestDto;
import com.demo.myproject.repository.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@SpringBootTest
@Transactional
class PostsServiceTest {

    @Autowired PostsService postsService;
    @Autowired PostsRepository repository;

    @PersistenceContext
    EntityManager em;

    @AfterEach
    public void deleteAll() {
        repository.deleteAll();
    }

    //find
    @Test
    public void findAll() {
        PostsSaveRequestDto requestDto1 = new PostsSaveRequestDto("제목1", "내용1");
        PostsSaveRequestDto requestDto2 = new PostsSaveRequestDto("제목2", "내용2");
        PostsSaveRequestDto requestDto3 = new PostsSaveRequestDto("제목3", "내용3");

        em.persist(requestDto1.toEntity());
        em.persist(requestDto2.toEntity());
        em.persist(requestDto3.toEntity());

        em.flush();
        em.clear();

        List<PostsResponseDto> postsResponseDtos = postsService.find();

        Assertions.assertThat(postsResponseDtos.size()).isEqualTo(3);
        Assertions.assertThat(postsResponseDtos.get(0).getTitle()).isEqualTo("제목1");
        Assertions.assertThat(postsResponseDtos.get(0).getContent()).contains("내용");
        Assertions.assertThat(postsResponseDtos.get(0).getTitle()).hasToString("제목1");
//        for (PostsResponseDto postsResponseDto : postsResponseDtos) {
//
//            System.out.println("postsResponseDto.getTitle() = " + postsResponseDto.getTitle());
//            System.out.println("postsResponseDto.getContent() = " + postsResponseDto.getContent());
//        }
    }

    //findOne
    @Test
    public void findOne() {
        PostsSaveRequestDto requestDto = new PostsSaveRequestDto("제목FindOne", "내용FindOne");
        Long savedEntityId = postsService.save(requestDto);
        em.flush();
        em.clear();

        PostsResponseDto findOne = postsService.findOne(savedEntityId);
        Assertions.assertThat(findOne.getId()).isEqualTo(savedEntityId);
        Assertions.assertThat(findOne.getTitle()).isEqualTo("제목FindOne");
        Assertions.assertThat(findOne.getContent()).isEqualTo("내용FindOne");

    }
    //save
    @Test
    public void save() {
        PostsSaveRequestDto requestDto = new PostsSaveRequestDto("제목FindOne", "내용FindOne");
        Long savedEntityId = postsService.save(requestDto);
        em.flush();
        em.clear();

        PostsResponseDto findOne = postsService.findOne(savedEntityId);
        Assertions.assertThat(findOne.getId()).isEqualTo(savedEntityId);
        Assertions.assertThat(findOne.getTitle()).isEqualTo("제목FindOne");
        Assertions.assertThat(findOne.getContent()).isEqualTo("내용FindOne");
    }

    //update
    @Test
    public void update() {
        PostsSaveRequestDto requestDto = new PostsSaveRequestDto("제목FindOne", "내용FindOne");
        Long savedEntityId = postsService.save(requestDto);
        em.flush();
        em.clear();

        PostsResponseDto findOne = postsService.findOne(savedEntityId);
        PostsUpdateRequestDto postsUpdateRequestDto = new PostsUpdateRequestDto("update 제목", "update 내용");
        Long updateEntityId = postsService.update(findOne.getId(), postsUpdateRequestDto);
        em.flush();
        em.clear();

        PostsResponseDto updatedOne = postsService.findOne(updateEntityId);

        Assertions.assertThat(updatedOne.getTitle()).isEqualTo("update 제목");
        Assertions.assertThat(updatedOne.getContent()).isEqualTo("update 내용");
    }

    //delete
    @Test
    public void delete() {
        PostsSaveRequestDto requestDto = new PostsSaveRequestDto("제목FindOne", "내용FindOne");
        Long savedEntityId = postsService.save(requestDto);
        em.flush();
        em.clear();

        PostsResponseDto findOne = postsService.findOne(savedEntityId);

        postsService.delete(findOne.getId());

        Assertions.assertThatThrownBy(() -> postsService.findOne(findOne.getId()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("존재하지");
    }

}