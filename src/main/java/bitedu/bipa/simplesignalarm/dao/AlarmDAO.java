package bitedu.bipa.simplesignalarm.dao;

import bitedu.bipa.simplesignalarm.mapper.AlarmMapper;
import bitedu.bipa.simplesignalarm.model.dto.AlarmDTO;
import bitedu.bipa.simplesignalarm.model.dto.AlarmReqDTO;
import bitedu.bipa.simplesignalarm.model.dto.UserApprovalDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlarmDAO {

    private final AlarmMapper alarmMapper;

    public AlarmDAO(AlarmMapper mapper) {
        this.alarmMapper = mapper;
    }

    public int insertAlarm(AlarmReqDTO alarmReqDTO) {
        return alarmMapper.insertAlarm(alarmReqDTO);
    }

    public String selectDefaultMessage(String alarmCode) {
        return alarmMapper.selectDefaultMessage(alarmCode);
    }

    public List<AlarmDTO> selectAlarm(int orgUserId){
        return alarmMapper.alarmSelect(orgUserId);
    }

    // 문서명 들고오기
    public UserApprovalDTO selectApprovalDocTitle(String alarmDate, int orgUserId, String alarmCode, int approvalDocId){
        return alarmMapper.selectApprovalDocTitle(alarmDate, orgUserId, alarmCode, approvalDocId);
    }

    // 결재자 들고오기
    public UserApprovalDTO selectApprovalUserName(int alarmId){
        return alarmMapper.selectApprovalUserName(alarmId);
    }

    // 안읽은 알림 총 갯수
    public int alarmCount(int orgUserId){
        return alarmMapper.AlarmCount(orgUserId);
    }

    // 알림 읽음 처리
    public boolean updateConfirmationStatus(int alarmId){
        return alarmMapper.updateConfirmationStatus(alarmId);
    }

}
