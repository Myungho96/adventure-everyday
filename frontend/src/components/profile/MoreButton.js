import { RiMoreFill } from "react-icons/ri";
import MoreList from "./MoreList";
import style from "./MoreButton.module.css";

function MoreButton(props) {
  return (
    <div className={style.buttonContainer}>
      <RiMoreFill size={25} onClick={props.toggle} />
      {props.isOn && <MoreList isMe={props.isMe} />}
    </div>
  );
}

export default MoreButton;
