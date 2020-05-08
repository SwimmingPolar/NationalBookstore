zpackage com.admin.service.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.admin.mapper.AdminBookMapper;
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.member.MemberVO;

import lombok.Setter;

@Service
public class AdminBookServiceImpl implements AdminBookService{
	
	@Setter(onMethod_ = {@Autowired})
	private AdminBookMapper mapper;

	@Override
	public List<EBookVO> statusLike() {			//좋아요
		// TODO Auto-generated method stub
		List<EBookVO> list = mapper.statusLike();
		return list;
	}

	@Override
	public List<EBookVO> statusLookup() {		//조회수
		// TODO Auto-generated method stub
		List<EBookVO> list = mapper.statusLookup();
		return list;
	}

	@Scheduled(cron = "0 0 0 01 * *")
	@Override
	public void resetLookup() {					//조회수 초기화
		// TODO Auto-generated method stub
		mapper.resetLookup();
	}

	@Override
	public List<MemberVO> bestReader(String date) {			//많이 읽은 사람
		// TODO Auto-generated method stub
		String day = "%"+date+"%";
		List<MemberVO> list = mapper.bestReader(day);		
		return list;
	}

	@Override
	public EBookVO insertBook(EBookVO vo) {			//책 등록
		// TODO Auto-generated method stub
		return mapper.insertBook(vo);
	}

	@Override
	public Boolean updateBook(EBookVO vo) {			//책 수정
		// TODO Auto-generated method stub
		mapper.updateBook(vo);
		return true;
	}

	@Override
	public Boolean deleteBook(int[] booknum) {			//책 삭제
		// TODO Auto-generated method stub
		
		ArrayList<Integer> number = new ArrayList<Integer>();
		for(int i : booknum) {
			number.add(i);
		}
			
		Map list = new HashMap();
		list.put("numberlist", number);
			
		int num = mapper.deleteBook(list);
		if(num==0) return false;	
		return true;
	}
	
	
}
