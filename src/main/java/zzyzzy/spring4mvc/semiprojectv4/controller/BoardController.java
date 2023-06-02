package zzyzzy.spring4mvc.semiprojectv4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zzyzzy.spring4mvc.semiprojectv4.model.Board;
import zzyzzy.spring4mvc.semiprojectv4.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired private BoardService bdsrv;

    @GetMapping("/list")
    public ModelAndView list(int cpg) { //컨트롤러의 매개변수는 주소창에 ?cpg=1 로 나태내어 매개변수 값을 1로 넣어주는것이다.
        ModelAndView mv = new ModelAndView();
        mv.setViewName("board/list.tiles");

        mv.addObject("bdlist", bdsrv.readBoard(cpg));   //sql문으로 페이지에 출력하는 데이터
        mv.addObject("cpg", cpg);                        //cpg로 페이지네이션 위치 표시
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);  //시작 페이지 계산하기
        mv.addObject("cntpg", bdsrv.countBoard());       //총 페이지 수

        return mv;
    }

    @GetMapping("/find") // 검색 처리
    public ModelAndView find(int cpg, String ftype, String fkey) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("bdlist", bdsrv.readBoard(cpg, ftype, fkey));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", bdsrv.countBoard(ftype, fkey));
        mv.setViewName("board/list.tiles");
        return mv;
    }



    @GetMapping("/write")
    public String write(){
        return "board/write.tiles";
    }

    @PostMapping("/write")
    public String writeok(Board bd){   //이름이 같으면 오류남  postMapping은 동작들 오류가나면 이쪽으로 정상작동이면 이쪽으로
        String viewPage ="error.tiles";   //error페이지
        if(bdsrv.newBoard(bd)){   //만약 Service에 newBoard(bd)가 참,1 이라면 아래 주소로 실행해라
            viewPage="redirect:/board/list?cpg=1";
        }

        return viewPage;
    }


    


    @GetMapping("/view")
    public ModelAndView view(String bno){  //주소창에 bno를 넘겨 받아서 bno를 토대로 게시글을 가져오자
        ModelAndView mv= new ModelAndView();
        mv.addObject("bd",bdsrv.readOneBoard(bno));  //프론트쪽으로 보냄 - 보낼 때 데이터를 bd로 가내겠다.
        mv.setViewName("board/view.tiles");

        return mv;
    }


}